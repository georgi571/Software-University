function depositCalculator(depositSum, months, rate) {
    const amount = depositSum + months * ((depositSum * rate / 100) / 12);

    console.log(amount);
}