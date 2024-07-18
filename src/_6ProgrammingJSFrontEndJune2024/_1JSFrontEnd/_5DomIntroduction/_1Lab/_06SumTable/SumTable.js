function sumTable() {
    const tableData = document.querySelectorAll('tr td:last-of-type:not(#sum)');
    const tableSum = document.getElementById('sum');
    let sum = 0;
    for (let tableDatum of tableData) {
        sum += Number(tableDatum.textContent);
    }
    tableSum.textContent = sum;
}