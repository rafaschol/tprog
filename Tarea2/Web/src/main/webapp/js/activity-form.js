
var currentTab;
const registerForm = document.getElementById('activity-form');
const prevButton = document.getElementById('prev-button');
const nextButton = document.getElementById('next-button');
const registerButton = document.getElementById('submit-button');
const nombreInput = document.getElementById('nombreInput');
const descripcionTextArea = document.getElementById('descripcionTextArea');
const duracionInput = document.getElementById('duracionInput');
const costoInput = document.getElementById('costoInput');
const categoriasSelect = document.getElementById('categoriasSelect');
const tabs = document.getElementsByClassName('form-tab');





function setTabButtons() {
  if (currentTab == 0 || currentTab == 1) {
    prevButton.style.display = 'none';
 
  } else {
    prevButton.style.display = 'initial';
 
  }
  if (currentTab == 0 || currentTab == (tabs.length - 1)) {
    nextButton.style.display = 'none';
    if (currentTab == (tabs.length - 1)) {
      registerButton.style.display = 'initial';
    }
  } else {
    nextButton.style.display = 'initial';
    registerButton.style.display = 'none';
  }
}

function loadForm() {
  currentTab = parseInt(registerForm.dataset.tab);

  tabs[currentTab].classList.toggle('active');
  setTabButtons();
}
function esValido() {
  switch (currentTab) {
    case 1:
     

      if (nombreInput.validity.valid && descripcionTextArea.validity.valid && duracionInput.validity.valid && costoInput.validity.valid) {
        return true;
      }
      return registerForm.reportValidity();
      break;

    case 2:
      if (categoriasSelect.validity.valid) {
        return true;
      }
      return registerForm.reportValidity();
      break;
    
    
  }
}

function moveTab(step) {
  if (step == 1 && currentTab != 0) {
    if (!esValido()) return false;
  }

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