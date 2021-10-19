var currentTab;
const datePickerId = document.getElementById('nacimientoInput');
const registerForm = document.getElementById('register-form');
const socioButton = document.getElementById('socio-button');
const profesorButton = document.getElementById('profesor-button');
const prevButton = document.getElementById('prev-button');
const nextButton = document.getElementById('next-button');
const registerButton = document.getElementById('register-button');
const registeredText = document.getElementById('registered-text');
const registroLabel = document.getElementById('registro-label');
const profesorTab = document.getElementById('profesor-tab');
const emailInput = document.getElementById('emailInput');
const passwordInput = document.getElementById('passwordInput');
const passwordConfirmInput = document.getElementById('passwordConfirmInput');
const nombreInput = document.getElementById('nombreInput');
const apellidoInput = document.getElementById('apellidoInput');
const nombreUsuarioInput = document.getElementById('nombreUsuarioInput');
const nacimientoInput = document.getElementById('nacimientoInput');
const descripcionTextArea = document.getElementById('descripcionTextArea');
const tabs = document.getElementsByClassName('form-tab');

function loadForm() {
  currentTab = parseInt(registerForm.dataset.tab);

  if (registerForm.dataset.usertype && currentTab != 0) {
    const esProfesor = registerForm.dataset.usertype == "profesor";

    if (!esProfesor) {
      registroLabel.innerText += ' de socio';
    } else {
      registroLabel.innerText += ' de profesor';
      profesorTab.classList.add('form-tab');
      descripcionTextArea.required = true;
    }
  }

  tabs[currentTab].classList.toggle('active');
  setTabButtons();
}

function setTabButtons() {
  if (currentTab == 0 || currentTab == 1) {
    prevButton.style.display = 'none';
    registeredText.style.display = 'inital';
  } else {
    prevButton.style.display = 'initial';
    registeredText.style.display = 'none';
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

function esValido() {
  switch (currentTab) {
    case 1:
      if (passwordInput.value != passwordConfirmInput.value) {
        passwordConfirmInput.setCustomValidity('Las contraseñas ingresadas no coinciden.');
      } else {
        passwordConfirmInput.setCustomValidity('');
      }

      if (emailInput.validity.valid && passwordInput.validity.valid && passwordConfirmInput.validity.valid) {
        return true;
      }
      return registerForm.reportValidity();
      break;

    case 2:
      if (nombreInput.validity.valid && apellidoInput.validity.valid && nombreUsuarioInput.validity.valid && nacimientoInput.validity.valid) {
        return true;
      }
      return registerForm.reportValidity();
      break;
    
    case 3:
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
datePickerId.max = new Date().toISOString().split("T")[0];

socioButton.addEventListener('click', event => {
  event.preventDefault();
  registroLabel.innerText += ' de socio';
  moveTab(1);
});
profesorButton.addEventListener('click', event => {
  event.preventDefault();
  registroLabel.innerText += ' de profesor';
  profesorTab.classList.add('form-tab');
  descripcionTextArea.required = true;
  moveTab(1);
});
prevButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(-1);
});
nextButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(1);
});