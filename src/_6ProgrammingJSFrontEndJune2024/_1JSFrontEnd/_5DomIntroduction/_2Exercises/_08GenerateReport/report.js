function generateReport() {
    const tableHeadElement = document.querySelectorAll('table thead th');
    const tableRowElement = document.querySelectorAll('table tbody tr');
    const outputElement = document.querySelector('#output');
    const columns = [];
    for (let tableHead of tableHeadElement) {
        const checkBox = tableHead.querySelector('input[type=checkbox]');
        columns.push({
            name: tableHead.textContent.toLowerCase().trim(),
            active: checkBox.checked,
        });
    }
    let rows = [];
    for (let tableRow of tableRowElement) {
        const tableData = tableRow.querySelectorAll('td');
        let row = {};
        for (let i = 0; i < tableData.length; i++) {
            if (columns[i].active) {
                row[columns[i].name] = tableData[i].textContent;
            }
        }
        rows.push(row)
    }
    outputElement.value = JSON.stringify(rows, null, 2);
}