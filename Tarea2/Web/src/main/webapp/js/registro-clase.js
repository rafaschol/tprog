const registroNormalButton = document.getElementById('registroNormal');
const registroCuponeraButton = document.getElementById('registroCuponera');
const cuponeraSelect = document.getElementById('cuponeraSelect');

registroNormalButton.addEventListener('change', () => {
  cuponeraSelect.disabled = true;
});
registroCuponeraButton.addEventListener('change', () => {
  cuponeraSelect.disabled = false;
});