const seguirButton = document.getElementById('seguir-button');

seguirButton.addEventListener('click', () => {
  const siguiendo = seguirButton.classList.contains('siguiendo');

  if (!siguiendo) {
    seguirButton.innerText = 'Siguiendo';
    seguirButton.classList.remove('btn-primary');
    seguirButton.classList.add('btn-outline-primary');
  } else {
    seguirButton.innerText = 'Seguir';
    seguirButton.classList.remove('btn-outline-primary');
    seguirButton.classList.add('btn-primary');
  }

  seguirButton.classList.toggle('siguiendo');
});

seguirButton.addEventListener('mouseover', () => {
  const siguiendo = seguirButton.classList.contains('siguiendo');
  if (siguiendo) {
    seguirButton.innerText = 'Dejar de seguir';
  }
});
seguirButton.addEventListener('mouseout', () => {
  const siguiendo = seguirButton.classList.contains('siguiendo');
  if (siguiendo) {
    seguirButton.innerText = 'Siguiendo';
  }
});