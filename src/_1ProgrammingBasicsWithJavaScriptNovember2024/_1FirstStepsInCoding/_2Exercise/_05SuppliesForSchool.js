function suppliesForSchool(packageOfPens, packageOfMarkers, literOfDetergent, percentDiscount) {
    const penPackagePrice = 5.80;
    const markerPackagePrice = 7.20;
    const detergentLiterPrice = 1.20;

    const sumForPens = penPackagePrice * packageOfPens;
    const sumForMarker = markerPackagePrice * packageOfMarkers;
    const sumForDetergent = detergentLiterPrice * literOfDetergent;

    const totalPrice = sumForDetergent + sumForMarker + sumForPens;
    const discount = totalPrice * percentDiscount / 100;
    const priceAfterDiscount = totalPrice - discount;

    console.log(priceAfterDiscount);
}