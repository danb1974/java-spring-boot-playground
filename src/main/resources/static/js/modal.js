$(() => {
    let modal;

    window.htmx.on("htmx:afterSwap", (e) => {
        let target = $(e.detail.target);

        let modals = target.find(".modal");
        if (!modals.length) {
            return;
        }

        modal = new bootstrap.Modal(modals[0]);
        modal.show();
    });

    // $("body").on("click", ".modal button[hx-*]", (e) => {
    //     modal.hide();
    // });
});
