

const datePickerId = document.getElementById('FechaInput');
const minSocios = document.getElementById('minSociosInput');
const maxSocios = document.getElementById('maxSociosInput');
const classForm = document.getElementById('class-form');
const createButton = document.getElementById('create-button');
let validador = false;

function esValido() {
  		validador = false;
      if (minSocios.value > maxSocios.value) {
        minSocios.setCustomValidity('La cantidad de minima debe ser menor o igual a la maxima');
		validador = true;
		return minSocios.reportValidity();	
      } else {
		
		 minSocios.setCustomValidity('');
		return true;
		
      }
}

createButton.addEventListener('click', event => {
  esValido();
if (validador) event.preventDefault();
});

datePickerId.min = new Date().toISOString().split("T")[0];