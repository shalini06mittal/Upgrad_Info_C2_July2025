import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reverse',
  standalone: false
})
export class ReversePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    console.log(value)
    value=value.toLowerCase()
    return value.split('').reverse().join('');
  }

}
