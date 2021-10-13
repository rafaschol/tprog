const sidebarFilters = document.getElementsByClassName('sidebar-filter');
const filterTags = document.getElementsByClassName('tag');
const inSearchPage = window.location.pathname.includes('buscar');

if (inSearchPage) {

  for (let filter of sidebarFilters) {
	const searchParamsFilters = new URLSearchParams(window.location.search);
	
    const filterType = filter.classList.contains('institucion-filter') ? 'ins' : 'cat';
    const value = filter.innerHTML;

    searchParamsFilters.set(filterType, value);    
    filter.href = 'buscar?' + searchParamsFilters.toString();
  }

  const searchParamsTags = new URLSearchParams(window.location.search);
  for (let tag of filterTags) {
    const tagType = tag.classList.contains('institucion-tag') ? 'ins' : 'cat';

    tag.addEventListener('closed.bs.alert', () => {
      searchParamsTags.delete(tagType);
      window.location.href = 'buscar?' + searchParamsTags.toString();
    })
  }

}
