function getDateStr_yyyymmdd(dateStr) {
    var date = new Date(dateStr);
    var yyyy = date.getFullYear().toString();
    var mm = (date.getMonth()+1).toString();
    var dd = date.getDate().toString();

    return yyyy + "." + mm + "." + dd;
}