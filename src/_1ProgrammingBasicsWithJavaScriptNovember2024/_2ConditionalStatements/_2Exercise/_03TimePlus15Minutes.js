function timePlus15Minutes(hours, minutes) {
    minutes += 15;

    if (minutes >= 60) {
        hours++;
        minutes -= 60;

        if (hours >= 24) {
            hours -= 24;
        }
    }

    if (minutes < 10) {
        console.log(`${hours}:0${minutes}`)
    } else {
        console.log(`${hours}:${minutes}`)
    }
}