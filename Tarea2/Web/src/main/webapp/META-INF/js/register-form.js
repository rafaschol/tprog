let currentTab = 0;

const prevButton = document.getElementById('prev-button');
const nextButton = document.getElementById('next-button');
const registerButton = document.getElementById('register-button');
const registeredText = document.getElementById('registered-text');

function moveTab(step) {
  let tabs = document.getElementsByClassName('form-tab');
  tabs[currentTab].classList.toggle('active');
  currentTab += step;
  tabs[currentTab].classList.toggle('active');

  if (currentTab == 0) {
    prevButton.style.display = 'none';
    registeredText.style.display = 'initial';
  } else {
    prevButton.style.display = 'initial';
    registeredText.style.display = 'none';
  }
  if (currentTab == (tabs.length - 1)) {
    nextButton.style.display = 'none';
    registerButton.style.display = 'initial';
  } else {
    nextButton.style.display = 'initial';
    registerButton.style.display = 'none';
  }
}

prevButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(-1);
});
nextButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(1);
});