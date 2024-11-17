function tradeCommissions(city, sales) {
    let commissionPercentage = 0;

    if (city === "Sofia") {
        if (sales > 10000) {
            commissionPercentage = 0.12;
        } else if (sales > 1000) {
            commissionPercentage = 0.08;
        } else if (sales > 500) {
            commissionPercentage = 0.07;
        } else if (sales >= 0) {
            commissionPercentage = 0.05;
        } else {
            console.log(`error`);
            return;
        }
    } else if (city === "Varna") {
        if (sales > 10000) {
            commissionPercentage = 0.13;
        } else if (sales > 1000) {
            commissionPercentage = 0.10;
        } else if (sales > 500) {
            commissionPercentage = 0.075;
        } else if (sales >= 0) {
            commissionPercentage = 0.045;
        } else {
            console.log(`error`);
            return;
        }
    } else if (city === "Plovdiv") {
        if (sales > 10000) {
            commissionPercentage = 0.145;
        } else if (sales > 1000) {
            commissionPercentage = 0.12;
        } else if (sales > 500) {
            commissionPercentage = 0.08;
        } else if (sales >= 0) {
            commissionPercentage = 0.055;
        } else {
            console.log(`error`);
            return;
        }
    } else {
        console.log(`error`);
        return;
    }

    const commission = commissionPercentage * sales;

    console.log(`${commission.toFixed(2)}`);
}