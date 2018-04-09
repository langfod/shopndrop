var cartIdent;

const addProductToCart = async (productId) => {
    if (!cartIdent) await getNewCart()
    await putFetch("/api/cart/" + cartIdent + "/" + productId)
    await replaceElemWithFragment("/cart/" + cartIdent, document.querySelector("aside"))
    activateCartDeleteButtons()
}

const putFetch = (url) => fetch(url, { method: 'PUT' })
const deleteFetch = (url) => fetch(url, { method: 'DELETE' })

const replaceElemWithFragment = (url, element) => {
    return fetch(url).then(response => response.text()).then(respText => {
        const htmlTemplate = document.createElement('template')
        htmlTemplate.innerHTML = respText
        element.replaceWith(htmlTemplate.content.firstChild)
    })
}

const subtractItemFromCart = async (itemId) => {
    await deleteFetch("/api/cart/" + cartIdent + "/" + itemId)
    await replaceElemWithFragment("/cart/" + cartIdent, document.querySelector("aside"))
    activateCartDeleteButtons()
}

const getNewCart = () => fetch("/api/cart").then(res => res.json()).then(resJson => cartIdent = resJson.id)

const activateCartDeleteButtons = () => {
document.querySelectorAll("button[id^='Subtract']").forEach(button => button.addEventListener('click', event => {
    subtractItemFromCart(event.target.getAttribute("data-cartItemId"))
}))}

document.querySelectorAll("button.product_buy_button").forEach(button => button.addEventListener('click', event => {
    addProductToCart(event.target.getAttribute("data-productId"))
}))
