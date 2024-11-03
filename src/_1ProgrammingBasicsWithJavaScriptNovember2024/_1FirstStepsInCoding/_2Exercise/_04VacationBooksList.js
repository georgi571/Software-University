function vacationBookList(numberOfPage, readPageInOneHour, numberOfDays) {
    const totalTimeToReadTheBook = numberOfPage / readPageInOneHour;
    const hoursPerDayToFinishTheBook = totalTimeToReadTheBook / numberOfDays;

    console.log(hoursPerDayToFinishTheBook);
}