function workingHours(hours, day) {
    let output = "";
    if (hours >= 10 && hours <= 18) {
        if (day === "Monday" || day === "Tuesday" || day === "Wednesday" || day === "Thursday" || day === "Friday" || day === "Saturday") {
            output = "open";
        } else {
            output = "closed";
        }
    } else {
        output = "closed";
    }

    console.log(`${output}`)
}