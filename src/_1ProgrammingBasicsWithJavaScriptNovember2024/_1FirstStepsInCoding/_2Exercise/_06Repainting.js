function repainting(nylon, paint, paintThinner, hours) {
    const priceForNylon = 1.50;
    const priceForPaint = 14.50;
    const priceForPaintThinner = 5.00;
    const priceForBags = 0.40;
    const percentForWorkerHourWork = 0.30;

    const sumForNylon = (nylon + 2) * priceForNylon;
    const sumForPaint = (paint * 1.10) * priceForPaint;
    const sumForPaintThinner = paintThinner * priceForPaintThinner;

    const sumForMaterials = sumForNylon + sumForPaint + sumForPaintThinner + priceForBags;
    const pricePerHourWork = sumForMaterials * percentForWorkerHourWork;

    const sumForWorkers = hours * pricePerHourWork;
    const totalSum = sumForMaterials + sumForWorkers;

    console.log(totalSum);
}