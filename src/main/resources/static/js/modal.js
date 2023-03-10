$(() => {
    // window.htmx.on("htmx:afterSwap", (e) => {
    //     let target = $(e.detail.target);
    // });

    let body = $("body");
    let bootstrapConfirmationModal = new bootstrap.Modal("#confirmationModal");


    body.on("click", "[data-action='rentMovieConfirm']", (e) => {
        let elem = $(e.currentTarget);
        let movieId = elem.data("movie-id");
        console.log(`confirm rent movie ${movieId}`);

        let modal = $("#confirmationModal");
        modal.find("[data-modal-title]").html("Confirmation");
        modal.find("[data-modal-content").html("Do you want to rent this movie?");
        modal.find("[data-modal-button]").attr("data-action", "rentMovie").attr("data-movie-id", movieId);

        bootstrapConfirmationModal.show();
    });

    body.on("click", "[data-action='rentMovie']", (e) => {
        let elem = $(e.currentTarget);
        let movieId = elem.data("movie-id");
        console.log(`execute rent movie ${movieId}`);

        window.htmx.ajax("POST", "/fragments/movie/rent", {
            values: {
                movieId: movieId
            },
            target: "[data-movie-row][data-movie-id='" + movieId + "']"
        }).then(() => {
            console.log("done");
        });

        bootstrapConfirmationModal.hide();
    });
});