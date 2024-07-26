function attachEventsListeners() {
    const inputElement = document.querySelector('#inputDistance');
    const outputElement = document.querySelector('#outputDistance');
    const buttonElement = document.querySelector('#convert');
    let numberFromInputInM = 0;
    let numberToOutput = 0;
    buttonElement.addEventListener('click', (event) => {
        const inputOptionElement = document.querySelector('#inputUnits').value;
        if (inputOptionElement === 'km') {
            numberFromInputInM = inputElement.value * 1000;
        } else if (inputOptionElement === 'm') {
            numberFromInputInM = inputElement.value;
        } else if (inputOptionElement === 'cm') {
            numberFromInputInM = inputElement.value * 0.01;
        } else if (inputOptionElement === 'mm') {
            numberFromInputInM = inputElement.value * 0.001;
        } else if (inputOptionElement === 'mi') {
            numberFromInputInM = inputElement.value * 1609.34;
        } else if (inputOptionElement === 'yrd') {
            numberFromInputInM = inputElement.value * 0.9144;
        } else if (inputOptionElement === 'ft') {
            numberFromInputInM = inputElement.value * 0.3048;
        } else if (inputOptionElement === 'in') {
            numberFromInputInM = inputElement.value * 0.0254;
        }
        const outputOptionElement = document.querySelector('#outputUnits').value;
        if (outputOptionElement === 'km') {
            numberToOutput = numberFromInputInM / 1000;
        } else if (outputOptionElement === 'm') {
            numberToOutput = numberFromInputInM;
        } else if (outputOptionElement === 'cm') {
            numberToOutput = numberFromInputInM / 0.01;
        } else if (outputOptionElement === 'mm') {
            numberToOutput = numberFromInputInM /0.001;
        } else if (outputOptionElement === 'mi') {
            numberToOutput = numberFromInputInM / 1609.34;
        } else if (outputOptionElement === 'yrd') {
            numberToOutput = numberFromInputInM / 0.9144;
        } else if (outputOptionElement === 'ft') {
            numberToOutput = numberFromInputInM / 0.3048;
        } else if (outputOptionElement === 'in') {
            numberToOutput = numberFromInputInM / 0.0254;
        }
        outputElement.value = numberToOutput;
    })
}