var initAccordion = function() {
    console.log("Initialising accordion");
    var accordionHeaderClickHandler = function(event) {
        var clicked_accordion_title = $(this);
        var sibling = clicked_accordion_title.next();
        if(sibling.css("display") == "none") {
            sibling.css("display", "block");
        } else {
            sibling.css("display", "none");
        }
    }
    $("div.accordion-item-outer-div div.accordion-item-title-div").off("click");
    $("div.accordion-item-outer-div div.accordion-item-title-div").on("click", accordionHeaderClickHandler);
}

$(document).ready(initAccordion);
