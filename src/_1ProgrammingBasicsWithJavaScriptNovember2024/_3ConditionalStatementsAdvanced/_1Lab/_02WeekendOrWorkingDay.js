function weekendOrWorkingDay(dayOfWeek) {
    let output = "";

    if (dayOfWeek === "Monday") {
        output = "Working day";
    } else if (dayOfWeek === "Tuesday") {
        output = "Working day";
    } else if (dayOfWeek === "Wednesday") {
        output = "Working day";
    } else if (dayOfWeek === "Thursday") {
        output = "Working day";
    } else if (dayOfWeek === "Friday") {
        output = "Working day";
    } else if (dayOfWeek === "Saturday") {
        output = "Weekend";
    } else if (dayOfWeek === "Sunday") {
        output = "Weekend";
    } else {
        output = "Error";
    }

    console.log(`${output}`)
}