jQuery(document).ready(function() {
    $("div.accordion-item-outer-div div.accordion-item-title-div").click( function(event) {
        var clicked_accordion_title = $(this); // jQuery wrapper for clicked element
        var sibling = clicked_accordion_title.next();
        if(sibling.css("display") == "none") {
            sibling.css("display", "block");
        } else {
            sibling.css("display", "none");
        }
    });
});