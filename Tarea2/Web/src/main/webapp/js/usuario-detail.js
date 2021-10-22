const seguirButton = document.getElementById('seguir-button');

seguirButton.addEventListener('mouseover', () => {
  const siguiendo = seguirButton.classList.contains('siguiendo');
  if (siguiendo) {
    seguirButton.innerText = 'Dejar de seguir';
    seguirButton.classList.remove('btn-outline-primary');
    seguirButton.classList.add('btn-outline-danger');
  }
});
seguirButton.addEventListener('mouseout', () => {
  const siguiendo = seguirButton.classList.contains('siguiendo');
  if (siguiendo) {
    seguirButton.innerText = 'Siguiendo';
    seguirButton.classList.remove('btn-outline-danger');
    seguirButton.classList.add('btn-outline-primary');
  }
});