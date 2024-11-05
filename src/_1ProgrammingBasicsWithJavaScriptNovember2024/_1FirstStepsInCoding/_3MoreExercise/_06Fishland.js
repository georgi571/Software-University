function fishland(mackerelPricePerKilogram, spratPricePerKilogram, kilosOfBonito, kilosOfSafrid, kilosOfMussels) {
    const bonitoPricePerKilogram = mackerelPricePerKilogram * 1.60;
    const safridPricePerKilogram = spratPricePerKilogram * 1.80;
    const musselsPricePerKilogram = 7.50;
    const sumForBonito = kilosOfBonito * bonitoPricePerKilogram;
    const sumForSafrid = kilosOfSafrid * safridPricePerKilogram;
    const sumForMussels = kilosOfMussels * musselsPricePerKilogram;
    const total = sumForMussels + sumForBonito + sumForSafrid;

    console.log(`${total.toFixed(2)}`)
}