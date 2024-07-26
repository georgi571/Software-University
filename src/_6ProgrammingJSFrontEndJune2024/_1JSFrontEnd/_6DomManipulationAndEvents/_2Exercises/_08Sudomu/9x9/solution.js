function solve() {
    const quickCheckButton = document.querySelector('tfoot button:first-child');
    const clearButton = document.querySelector('tfoot button:last-child');
    const table = document.querySelector('table');
    const checkParagraph = document.querySelector('#check p');
    const inputs = document.querySelectorAll('tbody input');
    inputs.forEach(input => {
        input.setAttribute('min', '1');
        input.setAttribute('max', '9');
    });
    quickCheckButton.addEventListener('click', checkSolution);
    clearButton.addEventListener('click', clearBoard);

    function checkSolution() {
        const size = 9;
        const matrix = Array.from({ length: size }, () => Array(size).fill(0));
        let isSolved = true;
        inputs.forEach((input, index) => {
            const value = parseInt(input.value);
            const row = Math.floor(index / size);
            const col = index % size;
            if (value >= 1 && value <= 9) {
                matrix[row][col] = value;
            } else {
                isSolved = false;
            }
        });
        for (let i = 0; i < size; i++) {
            const rowSet = new Set();
            const colSet = new Set();
            for (let j = 0; j < size; j++) {
                if (matrix[i][j] === 0 || matrix[j][i] === 0 || rowSet.has(matrix[i][j]) || colSet.has(matrix[j][i])) {
                    isSolved = false;
                    break;
                }
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (!isSolved) {
                break;
            }
        }
        for (let row = 0; row < size; row += 3) {
            for (let col = 0; col < size; col += 3) {
                const subGridSet = new Set();
                for (let r = 0; r < 3; r++) {
                    for (let c = 0; c < 3; c++) {
                        const value = matrix[row + r][col + c];
                        if (value === 0 || subGridSet.has(value)) {
                            isSolved = false;
                            break;
                        }
                        subGridSet.add(value);
                    }
                    if (!isSolved) {
                        break;
                    }
                }
                if (!isSolved) {
                    break;
                }
            }
            if (!isSolved) {
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