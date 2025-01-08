function excursionSale(input) {
    let index = 0;
    const excursionSea = input[index];
    index++;
    const excursionMountain = input[index];
    index++;
    let seaNew = excursionSea;
    let mountainNew = excursionMountain;
    let profit = 0;
    let command = input[index];
    index++;
    while (command !== "Stop") {
        const nameOfPackage = command;
        if (nameOfPackage === "sea") {
            if (seaNew > 0) {
                profit += 680;
            } else {
                profit += 0;
            }
            seaNew--;
        } else if (nameOfPackage === "mountain") {
            if (mountainNew > 0) {
                profit += 499;
            } else {
                profit += 0;
            }
            mountainNew--;
        }
        if (mountainNew <=0 && seaNew <= 0) {
            break;
        }
        command = input[index];
        index++;
    }

    if (mountainNew <= 0 && seaNew <= 0) {
        console.log(`Good job! Everything is sold.`);
    }
    console.log(`Profit: ${profit} leva.`);
}