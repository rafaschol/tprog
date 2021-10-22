var currentTab;
var formType;

const form = document.getElementById('multitab-form');
const prevButton = document.getElementById('prev-button');
const nextButton = document.getElementById('next-button');
const submitButton = document.getElementById('submit-button');
const tabs = document.getElementsByClassName('form-tab');

function loadForm() {
  currentTab = parseInt(form.dataset.tab);
  formType = form.dataset.pagetype;
  tabs[currentTab].classList.toggle('active');
  if (formType == 'clase') document.getElementById('fechaInput').min = new Date().toISOString().split("T")[0];
  setTabButtons();
}

function setTabButtons() {
  if (currentTab == 0) {
    prevButton.style.display = 'none';
  } else {
    prevButton.style.display = 'initial';
  }
  if (currentTab == (tabs.length - 1)) {
    nextButton.style.display = 'none';
    submitButton.style.display = 'initial';
  } else {
    nextButton.style.display = 'initial';
    submitButton.style.display = 'none';
  }
}

function esValidoFormularioActividad() {
  const nombreInput = document.getElementById('nombreInput');
  const descripcionInput = document.getElementById('descripcionTextArea');
  const duracionInput = document.getElementById('duracionInput');
  const costoInput = document.getElementById('costoInput');
  const categoriasSelect = document.getElementById('categoriasSelect');

  switch (currentTab) {
    case 0:
      if (isNaN(parseFloat(costoInput.value)) || parseFloat(costoInput.value) < 0) {
        costoInput.setCustomValidity('El costo ingresado no es válido.');
      } else {
        costoInput.setCustomValidity('');
      }

      return nombreInput.validity.valid && descripcionInput.validity.valid && duracionInput.validity.valid && costoInput.validity.valid ? true : form.reportValidity();

    case 1:
      return categoriasSelect.validity.valid ? true : form.reportValidity();

    default:
      return true;
  }
}

function esValidoFormularioClase() {
  switch (currentTab) {
    case 0:
      const actividadSelect = document.getElementById('actividadSelect');
      const nombreInput = document.getElementById('nombreInput');
      const fechaInput = document.getElementById('fechaInput');
      const horaInput = document.getElementById('horaInput');
      const minSociosInput = document.getElementById('minSociosInput');
      const maxSociosInput = document.getElementById('maxSociosInput');
      const urlInput = document.getElementById('urlInput');

      if (parseInt(minSociosInput.value) > parseInt(maxSociosInput.value)) {
        minSociosInput.setCustomValidity('La cantidad mínima de socios no puede ser mayor que la cantidad máxima de socios.');
      } else {
        minSociosInput.setCustomValidity('');
      }

      return actividadSelect.validity.valid && nombreInput.validity.valid && fechaInput.validity.valid && horaInput.validity.valid
        && minSociosInput.validity.valid && maxSociosInput.validity.valid && urlInput.validity.valid ? true : form.reportValidity();

    default:
      return true;
  }
}

function esValido() {
  if (formType == 'actividad') return esValidoFormularioActividad();
  if (formType == 'clase') return esValidoFormularioClase();
  return true;
}

function moveTab(step) {
  if (step == 1 && !esValido()) return false;

  tabs[currentTab].classList.toggle('active');
  currentTab += step;
  tabs[currentTab].classList.toggle('active');

  setTabButtons();
}

loadForm();

prevButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(-1);
});
nextButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(1);
});
