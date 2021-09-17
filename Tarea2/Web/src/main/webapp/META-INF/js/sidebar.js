window.addEventListener('DOMContentLoaded', event => {

  const siderbarToggler = document.body.querySelector('.sidebar-toggler');
  siderbarToggler.addEventListener('click', event => {
    event.preventDefault();
    document.body.classList.toggle('sidebar-toggled');
  });

});