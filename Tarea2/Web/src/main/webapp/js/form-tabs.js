let currentTab = 0;

const prevButton = document.getElementById('prev-button');
const nextButton = document.getElementById('next-button');
const submitButton = document.getElementById('submit-button');

function moveTab(step) {
  let tabs = document.getElementsByClassName('form-tab');
  tabs[currentTab].classList.toggle('active');
  currentTab += step;
  tabs[currentTab].classList.toggle('active');

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

prevButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(-1);
});
nextButton.addEventListener('click', event => {
  event.preventDefault();
  moveTab(1);
});