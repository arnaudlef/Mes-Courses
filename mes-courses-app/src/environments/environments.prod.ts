export const environment = {
    production: true,
    API_URL: 'https://mes-courses.arnaud-lefrancois.fr/api',
    listsUrl: () => `${ environment.API_URL }/lists`,
    listItemsUrl: () => `${ environment.API_URL }/list-items`,
    productsUrl: () => `${ environment.API_URL }/products`,
    authUrl: () => `${ environment.API_URL }/auth`,
    userUrl: () => `${ environment.API_URL }/users`
};