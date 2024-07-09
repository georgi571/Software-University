function meetings(input) {
    const meetings = {};
    for (let inputElement of input) {
        const meetingInfo = inputElement.toString().split(' ');
        if (!meetings[meetingInfo[0]]) {
            meetings[meetingInfo[0]] = meetingInfo[1];
            console.log(`Scheduled for ${meetingInfo[0]}`);
        } else {
            console.log(`Conflict on ${meetingInfo[0]}!`);
        }
    }
    for (let meeting in meetings) {
        console.log(`${meeting} -> ${meetings[meeting]}`)
    }
}