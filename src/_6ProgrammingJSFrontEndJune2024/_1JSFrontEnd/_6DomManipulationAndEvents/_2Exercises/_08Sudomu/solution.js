function solve() {
    const quickCheckButton = document.querySelector('tfoot button:first-child');
    const clearButton = document.querySelector('tfoot button:last-child');
    const table = document.querySelector('table');
    const checkParagraph = document.querySelector('#check p');
    const inputs = document.querySelectorAll('tbody input');
    quickCheckButton.addEventListener('click', checkSolution);
    clearButton.addEventListener('click', clearBoard);

    function checkSolution() {
        const matrix = Array.from({ length: 3 }, () => Array(3).fill(0));
        let isSolved = true;
        inputs.forEach((input, index) => {
            const value = parseInt(input.value);
            if (!value || value < 1 || value > 3) {
                isSolved = false;
            }
            const row = Math.floor(index / 3);
            const col = index % 3;
            matrix[row][col] = value;
        });
        for (let i = 0; i < 3; i++) {
            const row = new Set(matrix[i]);
            const col = new Set([matrix[0][i], matrix[1][i], matrix[2][i]]);
            if (row.size !== 3 || col.size !== 3) {
                isSolved = false;
                break;
            }
        }
        if (isSolved) {
            table.style.border = '2px solid green';
            checkParagraph.textContent = 'You solve it! Congratulations!';
            checkParagraph.style.color = 'green';
        } else {
            table.style.border = '2px solid red';
            checkParagraph.textContent = 'NOP! You are not done yet...';
            checkParagraph.style.color = 'red';
        }
    }

    function clearBoard() {
        inputs.forEach(input => input.value = '');
        table.style.border = 'none';
        checkParagraph.textContent = '';
        checkParagraph.style.color = '';
    }
}