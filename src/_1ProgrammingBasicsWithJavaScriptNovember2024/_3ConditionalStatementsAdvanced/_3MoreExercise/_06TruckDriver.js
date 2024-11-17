function truckDriver(season, kmPerMonth) {
    const PRICE_PER_KM_FOR_SEASON_SPRING_AND_AUTUMN_FOR_0_TO_5000_KM = 0.75;
    const PRICE_PER_KM_FOR_SEASON_SPRING_AND_AUTUMN_FOR_5001_TO_10000_KM = 0.95;
    const PRICE_PER_KM_FOR_SEASON_SPRING_AND_AUTUMN_FOR_10001_TO_20000_KM = 1.45;
    const PRICE_PER_KM_FOR_SEASON_SUMMER_FOR_0_TO_5000_KM = 0.90;
    const PRICE_PER_KM_FOR_SEASON_SUMMER_FOR_5001_TO_10000_KM = 1.10;
    const PRICE_PER_KM_FOR_SEASON_SUMMER_FOR_10001_TO_20000_KM = 1.45;
    const PRICE_PER_KM_FOR_SEASON_WINTER_FOR_0_TO_5000_KM = 1.05;
    const PRICE_PER_KM_FOR_SEASON_WINTER_FOR_5001_TO_10000_KM = 1.25;
    const PRICE_PER_KM_FOR_SEASON_WINTER_FOR_10001_TO_20000_KM = 1.45;

    const taxes = 0.10;

    let salaryPerMonth = 0.00;

    if (season === "Summer") {
        if (kmPerMonth <= 5000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_SUMMER_FOR_0_TO_5000_KM;
        } else if (kmPerMonth <= 10000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_SUMMER_FOR_5001_TO_10000_KM;
        } else if (kmPerMonth <= 20000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_SUMMER_FOR_10001_TO_20000_KM;
        }
    } else if (season === "Winter") {
        if (kmPerMonth <= 5000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_WINTER_FOR_0_TO_5000_KM;
        } else if (kmPerMonth <= 10000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_WINTER_FOR_5001_TO_10000_KM;
        } else if (kmPerMonth <= 20000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_WINTER_FOR_10001_TO_20000_KM;
        }
    } else if (season === "Autumn" || season === "Spring") {
        if (kmPerMonth <= 5000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_SPRING_AND_AUTUMN_FOR_0_TO_5000_KM;
        } else if (kmPerMonth <= 10000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_SPRING_AND_AUTUMN_FOR_5001_TO_10000_KM;
        } else if (kmPerMonth <= 20000) {
            salaryPerMonth = kmPerMonth * PRICE_PER_KM_FOR_SEASON_SPRING_AND_AUTUMN_FOR_10001_TO_20000_KM;
        }
    }

    const totalSalary = salaryPerMonth * 4;
    const totalSalaryAfterTaxes = totalSalary - (totalSalary * taxes);

    console.log(`${totalSalaryAfterTaxes.toFixed(2)}`);
}