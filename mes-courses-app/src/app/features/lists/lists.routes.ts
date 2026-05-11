import { Routes } from "@angular/router";
import { ListsIndex } from "./pages/lists-index/lists-index";
import { ListDetail } from "./pages/list-detail/list-detail";

export const LISTS_ROUTES: Routes = [
    {
        path: '',
        component: ListsIndex
    },
    {
        path: ':id',
        component: ListDetail
    }
];