function attachEventsListeners() {
    const daysElement = document.querySelector('#days');
    const hoursElement = document.querySelector('#hours');
    const minutesElement = document.querySelector('#minutes');
    const secondsElement = document.querySelector('#seconds');
    const buttonElements = document.querySelectorAll("input[type=button]");
    for (let buttonElement of buttonElements) {
        buttonElement.addEventListener('click', (event) => {
            if (buttonElement.id === 'daysBtn') {
                hoursElement.value = daysElement.value * 24;
                minutesElement.value = hoursElement.value * 60;
                secondsElement.value = minutesElement.value * 60;
            } else if (buttonElement.id === 'hoursBtn') {
                daysElement.value = hoursElement.value / 24;
                minutesElement.value = hoursElement.value * 60;
                secondsElement.value = minutesElement.value * 60;
            } else if (buttonElement.id === 'minutesBtn') {
                hoursElement.value = minutesElement.value / 60;
                daysElement.value = hoursElement.value / 24;
                secondsElement.value = minutesElement.value * 60;
            } else if (buttonElement.id === 'secondsBtn') {
                minutesElement.value = secondsElement.value / 60;
                hoursElement.value = minutesElement.value / 60;
                daysElement.value = hoursElement.value / 24;
            }
        });
    }
}