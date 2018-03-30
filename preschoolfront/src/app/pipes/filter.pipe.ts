import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'searchFilter'
})
export class SearchPipe implements PipeTransform {
  public transform(value, keys: string, searchText: string) {

    if (!searchText) return value;
    return (value || []).filter((item) => keys.split(',').some(key => item.hasOwnProperty(key) && new RegExp(searchText, 'gi').test(item[key])));

  }

  /*transform(items: any[], searchText: string): any[] {
    f(!items) return [];
    if(!searchText) return items;
	searchText = searchText.toLowerCase();
	return items.filter( it => {
	      return it.toLowerCase().(searchText);
	    });
   }*/
}