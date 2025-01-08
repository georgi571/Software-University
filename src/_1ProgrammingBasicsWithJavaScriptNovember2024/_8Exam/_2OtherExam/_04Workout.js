function workout(input) {
    let index = 0;
    const numberOfDays = Number(input[index]);
    index++;
    const kmRunFirstDay = Number(input[index]);
    index++;
    let kmRunNextDay = kmRunFirstDay;
    let counter = kmRunFirstDay;
    for (let i = 0; i < numberOfDays; i++) {
        const percentNewKM = Number(input[index]);
        index++;
        const kmForThisDay = kmRunNextDay + (kmRunNextDay * (percentNewKM / 100));
        counter += kmForThisDay;
        kmRunNextDay = kmForThisDay;
    }
    const diff = Math.ceil(Math.abs(counter - 1000));
    if (counter >= 1000) {
        console.log(`You've done a great job running ${diff.toFixed(0)} more kilometers!`);
    } else {
        console.log(`Sorry Mrs. Ivanova, you need to run ${diff.toFixed(0)} more kilometers`);
    }
}