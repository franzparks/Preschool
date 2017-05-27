import {InMemoryDbService } from 'angular-in-memory-web-api';
import {SCHOOLS} from './services/mock-schools';


export class InMemoryDataService implements InMemoryDbService {
	createDb() {
			let schools = SCHOOLS;
			
		return {schools};
	}
}