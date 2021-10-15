const editButton = document.getElementById('edit-button');
const editableFields = document.getElementsByClassName('editable-field');

editButton.addEventListener('click', event => {
  const editing = !editButton.classList.contains('edit');

  if (!editing) {
    event.preventDefault();

    for (let field of editableFields) {
      field.readOnly = false;
      field.classList.remove('form-control-plaintext');
      field.classList.add('form-control');
    }

    editButton.classList.toggle('edit');
    editButton.setAttribute('type', 'submit');
    editButton.innerText = 'Guardar cambios';
    editButton.classList.remove('btn-primary');
    editButton.classList.add('btn-outline-primary');
  }

});