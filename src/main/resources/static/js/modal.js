function setModal(modal, title, content, data) {
    modal.find("[data-modal-title]").html(title);
    modal.find("[data-modal-content").html(content);

    let button = modal.find("[data-modal-button]");
    for (const [key, value] of Object.entries(data)) {
        button.attr(key, value);
    }
}

$(() => {
    let body = $("body");
    let confirmationModalSelector = "#confirmationModal";
    let confirmationModalObject = new bootstrap.Modal(confirmationModalSelector);

    //

    body.on("click", "[data-action='rentMovieConfirm']", (e) => {
        let elem = $(e.currentTarget);
        let movieId = elem.attr("data-movie-id");
        console.log(`confirm rent movie ${movieId}`);

        setModal($(confirmationModalSelector), "Confirmation", "Do you want to rent this movie?", {
            "data-action": "rentMovie",
            "data-movie-id": movieId,
        })
        confirmationModalObject.show();
    });

    body.on("click", "[data-action='rentMovie']", (e) => {
        let elem = $(e.currentTarget);
        let movieId = elem.attr("data-movie-id");
        console.log(`execute rent movie ${movieId}`);

        window.htmx.ajax("POST", "/fragments/movie/rent", {
            values: {
                movieId: movieId
            },
            target: "[data-movie-row][data-movie-id='" + movieId + "']"
        }).then(() => {
            console.log("done");
        });

        confirmationModalObject.hide();
    });

    //

    body.on("click", "[data-action='returnMovieConfirm']", (e) => {
        let elem = $(e.currentTarget);
        let movieId = elem.attr("data-movie-id");
        console.log(`confirm return movie ${movieId}`);

        setModal($(confirmationModalSelector), "Confirmation", "Do you want to return this movie?", {
            "data-action": "returnMovie",
            "data-movie-id": movieId,
        })
        confirmationModalObject.show();
    });

    body.on("click", "[data-action='returnMovie']", (e) => {
        let elem = $(e.currentTarget);
        let movieId = elem.attr("data-movie-id");
        console.log(`execute return movie ${movieId}`);

        window.htmx.ajax("POST", "/fragments/movie/return", {
            values: {
                movieId: movieId
            },
            target: "[data-movie-row][data-movie-id='" + movieId + "']"
        }).then(() => {
            console.log("done");
        });

        confirmationModalObject.hide();
    });
});