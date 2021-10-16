const registroClaseForm = document.getElementById('registro-clase-form');
const seleccionandoClase = registroClaseForm.dataset.tab == 0;

if (seleccionandoClase) {
  const actividadSelect = document.getElementById('actividadSelect');
  actividadSelect.addEventListener('change', event => {
    const newValue = event.target.value;
    const urlParams = new URLSearchParams(window.location.search);
    urlParams.set('actividad', newValue);
    window.location.href = 'clases/registro?' + urlParams.toString();
  });
} else {
  const registroNormalButton = document.getElementById('registroNormal');
  const registroCuponeraButton = document.getElementById('registroCuponera');
  const cuponeraSelect = document.getElementById('cuponeraSelect');

  registroNormalButton.addEventListener('change', () => {
    cuponeraSelect.disabled = true;
  });
  registroCuponeraButton.addEventListener('change', () => {
    cuponeraSelect.disabled = false;
  });
}