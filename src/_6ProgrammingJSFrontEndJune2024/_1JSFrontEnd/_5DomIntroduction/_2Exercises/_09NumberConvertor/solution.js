function solve() {
    const selectMenuTo = document.getElementById('selectMenuTo');
    const binaryOption = document.createElement('option');
    binaryOption.value = 'binary';
    binaryOption.textContent = 'Binary';
    const hexOption = document.createElement('option');
    hexOption.value = 'hexadecimal';
    hexOption.textContent = 'Hexadecimal';
    selectMenuTo.appendChild(binaryOption);
    selectMenuTo.appendChild(hexOption);
    const convertButton = document.querySelector('button');
    convertButton.addEventListener('click', () => {
        const decimalInput = document.getElementById('input').value;
        const convertTo = selectMenuTo.value;
        let result;
        if (convertTo === 'binary') {
            result = decimalToBinary(decimalInput);
        } else if (convertTo === 'hexadecimal') {
            result = decimalToHexadecimal(decimalInput);
        }
        document.getElementById('result').value = result;
    });

    function decimalToBinary(decimal) {
        return parseInt(decimal).toString(2);
    }

    function decimalToHexadecimal(decimal) {
        return parseInt(decimal).toString(16).toUpperCase();
    }
}