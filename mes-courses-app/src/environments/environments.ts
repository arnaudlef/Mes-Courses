export const environment = {
    production: false,
    API_URL: 'http://localhost:8080/api',
    listsUrl: () => `${ environment.API_URL }/lists`,
    listItemsUrl: () => `${ environment.API_URL }/list-items`,
    productsUrl: () => `${ environment.API_URL }/products`,
    authUrl: () => `${ environment.API_URL }/auth`,
    userUrl: () => `${ environment.API_URL }/users`
};