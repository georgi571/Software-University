function search() {
    const townsElement = document.getElementById('towns');
    const searchText = document.getElementById('searchText').value;
    let matchCount = 0;
    for (let town of townsElement.children) {
        if (town.textContent.toLowerCase().includes(searchText.toLowerCase())) {
            town.style.textDecoration = 'underline';
            town.style.fontWeight = 'bold';
            matchCount++;
        } else {
            town.style.textDecoration = 'none';
            town.style.fontWeight = 'normal';
        }
    }
    document.getElementById('result').textContent = `${matchCount} matches found`;
}
