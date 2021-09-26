const editButtons = document.querySelectorAll('.perfil-group button');

for (let editButton of editButtons) {

  editButton.addEventListener('click', event => {
    const editing = editButton.classList.contains('editing');
  
    const formGroup = editButton.closest('.perfil-group');
    const input = formGroup.querySelector('input') ? formGroup.querySelector('input') : formGroup.querySelector('textarea');
    const editIcon = editButton.querySelector('i.fa-edit');
    const saveIcon = editButton.querySelector('i.fa-save');
  
    if (!editing) {
      input.readOnly = false;
      input.classList.remove('form-control-plaintext');
      input.classList.add('form-control');
      editIcon.style.display = 'none';
      saveIcon.style.display = 'initial';
    } else {
      input.readOnly = true;
      input.classList.remove('form-control');
      input.classList.add('form-control-plaintext');
      editIcon.style.display = 'initial';
      saveIcon.style.display = 'none';

      // En el futuro acá se deben mandar los datos que se modificaron al servidor con una PATCH request
    }
  
    editButton.classList.toggle('editing');
  });

}
