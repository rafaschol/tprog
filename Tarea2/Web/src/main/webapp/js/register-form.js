let currentTab = 0;

const socioButton = document.getElementById('socio-button');
const profesorButton = document.getElementById('profesor-button');
const prevButton = document.getElementById('prev-button');
const nextButton = document.getElementById('next-button');
const registerButton = document.getElementById('register-button');
const registeredText = document.getElementById('registered-text');
const registroLabel = document.getElementById('registro-label');
const profesorTab = document.getElementById('profesor-tab');

function moveTab(step) {
  let tabs = document.getElementsByClassName('form-tab');
  tabs[currentTab].classList.toggle('active');
  currentTab += step;
  tabs[currentTab].classList.toggle('active');

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

socioButton.addEventListener('click', event => {
  event.preventDefault();
  registroLabel.innerText += ' de socio';
  moveTab(1);
});
profesorButton.addEventListener('click', event => {
  event.preventDefault();
  registroLabel.innerText += ' de profesor';
  profesorTab.classList.add('form-tab');
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