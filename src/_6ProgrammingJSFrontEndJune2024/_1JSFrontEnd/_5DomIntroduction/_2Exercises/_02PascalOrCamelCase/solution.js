function solve() {
    const text = document.getElementById('text').value;
    const namingConvention = document.getElementById('naming-convention').value;
    let resultElement = document.getElementById('result');
    let result = text.split(' ').map(word => word.charAt(0).toUpperCase() + word.slice(1).toLowerCase()).join('');
    if (namingConvention === 'Camel Case') {
        resultElement.textContent += result.charAt(0).toLowerCase() + result.slice(1);
    } else if (namingConvention === 'Pascal Case') {
        resultElement.textContent += result;
    } else {
        result = 'Error!'
        resultElement.textContent += result
    }
}