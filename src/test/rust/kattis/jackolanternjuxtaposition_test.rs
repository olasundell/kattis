#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn one() {

    }
}

use std::io::{self, BufRead, Write};

struct Quizzer<R, W> {
    reader: R,
    writer: W,
}

impl<R, W> Quizzer<R, W>
    where
        R: BufRead,
        W: Write,
{
    fn prompt(&mut self, question: &str) -> String {
        write!(&mut self.writer, "{}", question).expect("Unable to write");
        let mut s = String::new();
        self.reader.read_line(&mut s).expect("Unable to read");
        s
    }
}

#[test]
fn test_with_in_memory() {
    let input = b"I'm George";
    let mut output = Vec::new();

    let answer = {
        let mut quizzer = Quizzer {
            reader: &input[..],
            writer: &mut output,
        };

        quizzer.prompt("Who goes there?")
    };

    let output = String::from_utf8(output).expect("Not UTF-8");

    assert_eq!("Who goes there?", output);
    assert_eq!("I'm George", answer);
}

fn main() {
    let stdio = io::stdin();
    let input = stdio.lock();

    let output = io::stdout();

    let mut quizzer = Quizzer {
        reader: input,
        writer: output,
    };

    let answer = quizzer.prompt("Who goes there?");
    println!("was: {}", answer);
}