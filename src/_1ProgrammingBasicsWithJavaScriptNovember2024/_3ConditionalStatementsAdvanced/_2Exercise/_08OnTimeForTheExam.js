function onTimeForTheExam(hourOfExam, minutesOfExam, hourOfStudentCome, minutesOfStudentCome) {
    const examMinutesStart = hourOfExam * 60 + minutesOfExam;
    const studentMinutesCome = hourOfStudentCome * 60 + minutesOfStudentCome;

    const timeDifference = examMinutesStart - studentMinutesCome;

    const hours = Math.floor(Math.abs(timeDifference) / 60);
    const minutes = Math.abs(timeDifference) % 60;

    let timing = "";

    if (timeDifference > 30) {
        console.log(`Early`);
        timing = "before the start";
    } else if (timeDifference >= 0) {
        console.log(`On time`);
        timing = "before the start";
    } else {
        console.log(`Late`);
        timing = "after the start";
    }

    if (hours > 0) {
        console.log(`${hours}:${minutes.toString().padStart(2, '0')} hours ${timing}`);
    } else if (minutes > 0) {
        console.log(`${minutes} minutes ${timing}`);
    }
}