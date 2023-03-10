$(() => {
    window.htmx.on("htmx:afterSwap", (e) => {
        let children = e.detail.target.children;
        if (children.length === 0) {
            return;

        }

        let child = children[0];
        if (child.classList.contains("modal")) {
            let modal = new bootstrap.Modal(child);
            modal.show();
        }
    });
});
