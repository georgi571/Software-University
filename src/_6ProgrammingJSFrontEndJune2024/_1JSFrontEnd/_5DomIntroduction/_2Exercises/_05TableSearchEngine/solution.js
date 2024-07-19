function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        const tableRowElements = document.querySelectorAll('table.container tbody tr');
        const searchTextElement = document.getElementById('searchField');
        const searchText = searchTextElement.value;
        for (let tableRow of tableRowElements) {
            const tableDateElements = tableRow.querySelectorAll('td');
            tableRow.classList.remove('select');
            for (let tableDate of tableDateElements) {
                if (tableDate.textContent.includes(searchText)) {
                    tableRow.classList.add('select');
                    break;
                }
            }
        }
        searchTextElement.value = '';
    }
}