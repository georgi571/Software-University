function harvest(squareMetersOfVineyard, grapesForOneSquareMeter, neededLitersOfWine, numberOfWorkers){
    const PERCENT_TO_MAKE_WINE = 0.40;
    const GRAPES_NEED_FOR_1_LITER_WINE = 2.50;

    const grapes = squareMetersOfVineyard * grapesForOneSquareMeter;
    const grapesForWine = grapes * PERCENT_TO_MAKE_WINE;
    const wine = grapesForWine / GRAPES_NEED_FOR_1_LITER_WINE;

    const totalWine = Math.floor(wine);
    const diff = Math.abs(Math.floor(neededLitersOfWine - wine));
    const winePerWorker = Math.ceil(diff / numberOfWorkers);

    if (wine >= neededLitersOfWine) {
        console.log(`Good harvest this year! Total wine: ${totalWine} liters.`);
        console.log(`${diff} liters left -> ${winePerWorker} liters per person.`);
    } else {
        console.log(`It will be a tough winter! More ${diff} liters wine needed. `);
    }
}